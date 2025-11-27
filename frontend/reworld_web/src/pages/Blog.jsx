import Header from "../components/Header.jsx";
import Footer from "../components/Footer.jsx";
import {useState, useEffect} from "react";
import BlogMiniature from "../components/BlogMiniature.jsx";


export default function Blog(){
    const [entries, setEntries] = useState([]);

    useEffect(()=>{
        fetch("https://reworldhytale.com:3006")
            .then(async (res) => setEntries(await res.json()))
            .catch(err => console.log(err));

        setEntries([{
            title : "Bienvenidos a ReWorld",
            description: "ReWorld es un servidor de Hytale que bla bla bla y aquí hay mucho mucho relleno, de un par de líneas para hacer una simulación de lo que debería ser un texto del blog.",
            image: "https://cdn.hytale.com/5e7ba4723c9a2a001067939c_110___kweebec_leaf_ranger.jpg",
            date: "23/11/2025",
            type: "Release",
            target: "/blog/bienvenidos-a-reworld"
        }]);

    }, [])


    return (
        <>
            <Header />
            <main className="blog__main">
                <div className="title__container">
                    <h1>Blog</h1>
                </div>
                <hr />
                <div className="blog__container">
                    {
                        entries.map((entry) => (
                            <BlogMiniature
                                title={entry.title}
                                description={entry.description}
                                image={entry.image}
                                date={entry.date}
                                type={entry.type}
                                target={entry.target}
                                key={entry.date}
                            />
                        ))
                    }
                </div>
            </main>
            <Footer />
        </>
    )
}