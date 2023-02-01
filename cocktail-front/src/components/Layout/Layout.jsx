import React from 'react';

import Footer from './Footer';
import Header from './Header';
import Head from './Head';
import '../../assets/Layout.css';

const Layout = (props) => {
    return (
        <div className='layout'>
            <Head />

            <main>
                {props.children}
            </main>

            <Footer />
        </div>
    );
}

export default Layout;