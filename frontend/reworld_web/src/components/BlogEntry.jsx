import Header from "./Header.jsx";
import Footer from "./Footer.jsx";

export default function BlogEntry({id}) {

    // hacer fetch del contenido

    return (
        <>
            <Header />
            <main>
                <h1>{id}</h1>

            </main>
            <Footer />
        </>
    )
}