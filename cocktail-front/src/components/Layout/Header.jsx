import React from 'react';
import '../../assets/Layout.css';

const Header = () => {
    return (
        <header className='header'>
            <div className='contents'>
                <div>
                    <img src='https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTjB3yCQgbDwGy1PEIn9jxpa1VgjoLxI33gUQ&usqp=CAU' alt="" />
                </div>

                <nav className='navigation'>
                    <ul>
                        <li>칵테일</li>
                        <li>재료</li>
                        <li>게시판</li>
                        <li>시그니처</li>
                        <li>클래스</li>
                    </ul>
                </nav>
            </div>
        </header>
    );
}

export default Header;