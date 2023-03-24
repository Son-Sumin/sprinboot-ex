package com.bitacademy.cocktail.controller;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bitacademy.cocktail.domain.Member;
import com.bitacademy.cocktail.domain.Role;
import com.bitacademy.cocktail.jwt.JwtToken;
import com.bitacademy.cocktail.jwt.JwtTokenProvider;
import com.bitacademy.cocktail.jwt.SecurityUtil;
import com.bitacademy.cocktail.repository.MemberRepository;
import com.bitacademy.cocktail.service.MemberService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class MemberController {

	@Autowired
	MemberService memberService;

	private final PasswordEncoder passwordEncoder;
	private final JwtTokenProvider jwtTokenProvider;
	private final MemberRepository memberRepository;

	// 회원가입
	@PostMapping("/member/join")
	public void Join(@RequestBody Map<String, String> member) {
		System.out.println(member);
		memberService.join(Member.builder().name(member.get("name")).id(member.get("id"))
				.password(passwordEncoder.encode(member.get("password"))).nickname(member.get("nickname"))
				.birth(member.get("birth")).phoneNumber(member.get("phoneNumber")).role(Role.enuser)
				.profileImage("/common/defaultprofile.png").gender(member.get("gender")).build());
		System.out.println("회원가입성공");
	}

	// jwt로그인
	@PostMapping("/member/login")
	@CrossOrigin(origins = "*", exposedHeaders = "Authorization")
	public JwtToken testLogin(@RequestBody Map<String, String> user) {
		Member member = memberRepository.findById(user.get("id"))
						.orElseThrow(() -> new IllegalArgumentException("가입 되지 않은 아이디 입니다."));
		if (!passwordEncoder.matches(user.get("password"), member.getPassword())) {
			throw new IllegalArgumentException("아이디 또는 비밀번호가 맞지않습니다.");
		}
		JwtToken jwtToken = memberService.login(member.getId(), member.getPassword());
		return jwtToken;
		//		return jwtTokenProvider.createToken(member.getId(), member.getRole());
	}

	// jwt로그아웃
	@PostMapping("/member/logout")
	public ResponseEntity<Void> logout(@RequestHeader("Authorization") String accessToken) {
		memberService.logout(accessToken);
		System.out.println("로그아웃성공");
		return new ResponseEntity(HttpStatus.OK);
	}

	// 유저리스트
	@GetMapping("/member/list")
	public List<Member> memberList(Model model) {
		List<Member> memberList = memberService.memberList();
		model.addAttribute("memberList", memberList);

		return memberList;
	}

	@PostMapping("/test")
	public String test() {
		System.out.println("@@@" + SecurityContextHolder.getContext().getAuthentication().getName() + "@@@");
		System.out.println("id: " + SecurityUtil.getCurrentMemberId());
		return "test성공";
	}
	
	@GetMapping("/member/info")
	public Optional<Member> memberInfo() {
		System.out.println(memberService.memberInfo(SecurityUtil.getCurrentMemberId()));
		return memberService.memberInfo(SecurityUtil.getCurrentMemberId());
	}
	
	@CrossOrigin(origins = "*")
	@PatchMapping("/member/update")
	public void imgUpdate(@ModelAttribute Member member, MultipartFile file) throws Exception {
		member = memberService.memberInfo(SecurityUtil.getCurrentMemberId()).get();
		member.setProfileImage("");
	
		if(!file.isEmpty()) {
			String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\common";
	 		UUID uuid = UUID.randomUUID();
	 		String fileName = uuid + "_" + file.getOriginalFilename();
	 		
	 		File saveFile = new File(projectPath, fileName);
	 		file.transferTo(saveFile);
	 		
	 		member.setProfileImage("/common/" + fileName);
	 		memberService.save(member);	
		}
	}
}
