import React from 'react';
import '../../assets/Head.css';

const Head = () => {
    return (
        <header className="fixed trans" id="header">

            <div class="pc-menu">
            <link href="/css/renewal.css" rel="stylesheet" type="text/css"/>
                <div class="menu">
                <ul class="logo">
                    <li>
                        <a class="menu-a nav-height" href="#">
                        <img src="image/cocktailimages.jpg"/>
                        </a>
                    </li>
                </ul>
                <ul class="gnb">
                    <li class="menu-li off">
                        <a href="#">
                        칵테일
                        </a>
                    </li>
                    <li class="menu-li off">
                        <a href="#">
                        재료
                        </a>
                    </li>
                    <li class="menu-li off">
                        <a href="#">
                        게시판
                        </a>
                    </li>
                    <li class="menu-li off">
                        <a href="#">
                        시그니처
                        </a>
                    </li>
                    <li class="menu-li off">
                        <a href="#">
                        클래스
                        </a>
                    </li>
                </ul>

                <ul class="my_list">
                    <li>
                        <a href="#">
                        알림
                        </a>
                    </li>
                    <li>
                        <a href="#">
                        마이페이지
                        </a>
                    </li>
                    <li>
                        <a href="#">
                        로그아웃
                        </a>
                    </li>
                </ul>
                </div>
            </div>
        </header>
            );
}

export default Head;