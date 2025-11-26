import React from "react";
import { Link } from "react-router-dom";
import "../styles/Header.css";
import {useState} from "react";

export default function Header() {
    const [open, setOpen] = useState(false);

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

            <button className="header__collapsed__button open" onClick={() => setOpen(!open)}>
                <svg xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 -960 960 960" width="24px" fill="#e3e3e3">
                    <path d="M120-240v-80h720v80H120Zm0-200v-80h720v80H120Zm0-200v-80h720v80H120Z"/>
                </svg>
            </button>
            <ul className={`header__collapsed__menu ${open? "open" : ""}`}>
                <Link to="/" onClick={() => setOpen(false)}>INICIO</Link>
                <Link to="/blog" onClick={() => setOpen(false)}>BLOG</Link>
                <Link to="/shop" onClick={() => setOpen(false)}>TIENDA</Link>
            </ul>
        </header>
    );
}
