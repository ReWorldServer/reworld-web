import React, { useState } from "react";
import "../styles/Banner.css";

export default function Banner() {
    const [hover, setHover] = useState(false);

    return (
        <section className="banner">
            <div className="banner__content">
                <img
                    src="/logo_full.png"
                    alt="Logo"
                    className="banner__logo"
                />

                <button
                    className="banner__button"
                    onMouseEnter={() => setHover(true)}
                    onMouseLeave={() => setHover(false)}
                    onClick={() => {
                        navigator.clipboard.writeText("reworldhytale.com")
                            .then(() => {
                                document.getElementsByClassName("banner__alert")[0].className += " banner__alert--enabled";
                                setTimeout(() => {
                                    document.getElementsByClassName("banner__alert")[0].className = " banner__alert";
                                }, 1000)
                            })
                            .catch((err) => {
                                console.error("Error al copiar al portapapeles: ", err);
                            });
                    }}
                >
                    {hover ? "Jugar" : "reworldhytale.com"}
                </button>

                <p className="banner__alert">
                    ¡Copiado al portapapeles!
                </p>
            </div>
        </section>
    );
}
