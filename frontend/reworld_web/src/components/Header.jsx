import React from "react";
import { Link } from "react-router-dom";
import "../styles/Header.css";

export default function Header() {
    return (
        <header className="header">
            <a href="https://www.reworldhytale.com" className="header__logo">
                <img
                    src="/logo.png"
                    alt="Logo"
                />
            </a>

            <nav className="header__nav">
                <ul>
                    <Link to="/">INICIO</Link>
                    <Link to="/blog">BLOG</Link>
                    <Link to="/shop">TIENDA</Link>
                </ul>
            </nav>
        </header>
    );
}
