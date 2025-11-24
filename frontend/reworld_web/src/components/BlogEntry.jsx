import Header from "./Header.jsx";
import Footer from "./Footer.jsx";
import {useState, useEffect} from "react";

function parseComponent(component) {
    switch (component.type) {
        case "heading":
            return <><h3>{component.text}</h3><hr/></>
        case "paragraph":
            return <p>{component.text}</p>
        case "image":
            return <><img src={component.src} alt={component.alt} /><span>{component.text}</span></>
        default:
            console.error(`Unknown component '${component.type}'`);
    }
}

export default function BlogEntry({id}) {
    const [data, setData] = useState({
        title : "Bienvenidos a ReWorld",
        description: "ReWorld es un servidor de Hytale que bla bla bla y aquí hay mucho mucho relleno, de un par de líneas para hacer una simulación de lo que debería ser un texto del blog.",
        image: "https://cdn.hytale.com/5e7ba4723c9a2a001067939c_110___kweebec_leaf_ranger.jpg",
        date: "23/11/2025",
        type: "Release",
        target: "/blog/bienvenidos-a-reworld",
        content: [
            {
                type: "paragraph",
                text: "Esta es la primera entrada de ejemplo del blog de ReWorld. El servidor tiene que estar listo dentro de unos días pues este fin de semana por fin van a anunciar la fecha de Hytale, y creo honestamente que será dentro de muy poco..."
            },
            {
                type: "heading",
                text: "Empieza una nueva aventura"
            },
            {
                type: "paragraph",
                text: "En este servidor van a pasar cositas"
            }
        ]
    });

    useEffect(() => {
        fetch(`https://reworldhytale.com:3006/blog/${id}`)
            .then(async (res) => setData(await res.json()))
            .catch(err => console.log(err));
    }, [])

    return (
        <>
            <Header />
            <main className={"entry__main blog__main"}>
                <img src={data.image} alt="Banner" className={"entry__banner"}/>
                <h2>{data.title}</h2>
                <p className="blog-miniature__metadata">
                    <span>{data.date} </span>
                    -
                    <span className={`type__${data.type}`}> {data.type}</span>
                </p>
                {
                    data.content.map((item, i) => (
                        parseComponent(item)
                    ))
                }
            </main>
            <Footer />
        </>
    )
}