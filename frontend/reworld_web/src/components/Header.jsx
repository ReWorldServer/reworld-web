import React from "react";
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
                    <li><a href="https://www.reworldhytale.com">INICIO</a></li>
                    <li><a href="https://blog.reworldhytale.com">BLOG</a></li>
                    <li><a href="https://shop.reworldhytale.com">TIENDA</a></li>
                </ul>
            </nav>
        </header>
    );
}
