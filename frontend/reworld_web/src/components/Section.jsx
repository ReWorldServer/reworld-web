import React from "react";
import "../styles/Section.css";

export default function Section({ direction = "right", image, title, text, gradientColor }) {
    const isLeft = direction === "left";

    function colorToRGB(color) {
        const temp = document.createElement("div");
        temp.style.color = color;
        document.body.appendChild(temp);
        const computed = getComputedStyle(temp).color;
        document.body.removeChild(temp);
        return computed.match(/\d+,\s*\d+,\s*\d+/);
    }

    return (
        <section
            className={`section ${isLeft ? "section--left" : "section--right"}`}
            style={{
                backgroundImage: `url(${image})`,
                "--gradient-color-rgb": colorToRGB(gradientColor),
            }}
        >
            <div className="section__content">
                <h2>{title}</h2>
                <hr/>
                <p>{text}</p>
            </div>
        </section>
    );
}
