import Header from "../components/Header.jsx";
import Footer from "../components/Footer.jsx";

export default function Shop(){
    return (
        <>
            <Header />
            <main className="shop__main">
                <div className="title__container">
                    <h1>Tienda</h1>
                </div>
                <hr />
                <div className="shop__container">
                    <h1>¡Próximamente!</h1>
                    <p>La tienda abrirá junto con el servidor de Hytale. Mientras tanto, estate atento a nuesto <a href="https://discord.gg/CFmKF2xQMc">Discord</a>.</p>
                </div>
            </main>
            <Footer />
        </>
    )
}