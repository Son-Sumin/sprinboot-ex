package com.bitacademy.cocktail.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.bitacademy.cocktail.domain.Member;
import com.bitacademy.cocktail.domain.Role;
import com.bitacademy.cocktail.domain.Token;
import com.bitacademy.cocktail.jwt.JwtTokenProvider;
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
		memberService.join(Member.builder()
				.name(member.get("name"))
				.id(member.get("id"))
				.password(passwordEncoder.encode(member.get("password")))
				.nickname(member.get("nickname"))
				.birth(member.get("birth"))
				.phoneNumber(member.get("phoneNumber"))
				.role(Role.enuser)
				.profileImage("/common/defaultprofile.png")
				.gender(member.get("gender"))
				.build());
    }
    
	// jwt로그인
	@PostMapping("/member/login")
	public Token Login(@RequestBody Map<String, String> user) {
		System.out.println("user = " + user);
		Member member = memberRepository.findById(user.get("id"))
						.orElseThrow(() -> new IllegalArgumentException("가입 되지 않은 아이디 입니다."));
		if (!passwordEncoder.matches(user.get("password"), member.getPassword())) {
			throw new IllegalArgumentException("아이디 또는 비밀번호가 맞지않습니다.");
		}
		System.out.println("~~~~~~~~~" + jwtTokenProvider.createToken(member.getId(), member.getRole(), member.getNickname()));
//		return jwtTokenProvider.createToken(member.getId(), member.getRole(), member.getNickname());
		return Token.builder()
					.token(jwtTokenProvider.createToken(member.getId(), member.getRole(), member.getNickname()))
					.build();
	}
	
	// jwt로그아웃
		@PostMapping("/member/logout")
		public ResponseEntity<Void> logout(@RequestHeader("Authorization") String accessToken) {

			memberService.logout(accessToken);

			return new ResponseEntity(HttpStatus.OK);
		}

    
    //유저리스트
    @GetMapping("/member/list")
    public List<Member> memberList(Model model) {
    	List<Member> memberList = memberService.memberList();
    	model.addAttribute("memberList", memberList);
    	
    	return memberList;
    }
}
