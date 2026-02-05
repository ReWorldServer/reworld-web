import Footer from "../components/Footer.jsx"
import "../styles/WorkInProgress.css"
import {useState, useEffect} from "react";

export default function WorkInProgress() {
    const TEXT_OPTIONS = [
        "¡Capitán, todo a estribor!",
        "¡La tormenta es demasiado fuerte!",
        "La brújula... ¡se está volviendo loca!",
        "El Mar Dorado... ¡el Mar Dorado es real!",
        "¡Aguanten, camaradas!",
        "¿¡Hacia dónde estamos yendo!?",
        "¡Preparen los cañones!",
        "Las leyendas serán ciertas en aquel lugar...",
        "¿Seremos capaces de cruzar esta tormenta, capitán?",
        "¡Todo a babor!",
        "¡Las reliquias nos esperan, camaradas!",
        "Ha llegado el día por fin."
    ];
    const [text, setText] = useState(TEXT_OPTIONS[0]);
    const [visible, setVisible] = useState(true);

    useEffect(() => {
        let timeout;
        const cycle = () => {
            setVisible(false);
            timeout = setTimeout(() => {
                const randomIndex = Math.floor(Math.random() * TEXT_OPTIONS.length);
                setText(TEXT_OPTIONS[randomIndex]);
                setVisible(true);
                timeout = setTimeout(cycle, 5000)
            }, 10500)
        };
        timeout = setTimeout(cycle, 5000);
        return () => clearTimeout(timeout);
    }, );
    return (
        <>
            <main className="wip__main storm">
                <div className="storm__clouds"/>
                <div className="storm__lightning"/>
                <img src="/logo_full.webp" width={"60%"} className="wip__logo"/>
                <h1 id={"dialog_text"} style={{opacity: visible ? "1" : "0"}}>{text}</h1>
                <video autoPlay loop playsInline className={"storm__background"}>
                    <source src="/background.webm" type="video/webm"/>
                    <source src="/background.mp4" type="video/mp4"/>
                </video>
            </main>
            <Footer/>
        </>
    )
}