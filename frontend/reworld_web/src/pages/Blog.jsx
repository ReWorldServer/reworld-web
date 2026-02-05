import Header from "../components/Header.jsx";
import Footer from "../components/Footer.jsx";
import { useState, useEffect } from "react";
import BlogMiniature from "../components/BlogMiniature.jsx";

export default function Blog() {
  const [entries, setEntries] = useState([]);

  useEffect(() => {
    async function fetchPosts() {
      try {
        const res = await fetch("http://backend.reworldhytale.com:8080/api/blogposts");
        if (!res.ok) throw new Error(`HTTP ${res.status}`);
        const posts = await res.json();

        console.log("fetched posts:", posts); // <- depuración

        const slugify = (s = "") =>
          s
            .toLowerCase()
            .normalize("NFD")
            .replace(/[\u0300-\u036f]/g, "") // remove accents
            .replace(/[^a-z0-9]+/g, "-")
            .replace(/(^-|-$)/g, "");

        const mapped = posts.map((p) => ({
          id: p.id,
          title: p.title,
          description: p.description,
          image: p.image,
          date: p.datep ? new Date(p.datep).toLocaleDateString("es-ES") : "",
          type: p.type ?? "Release",
          // usar el id numérico en la ruta (puedes mantener slug si quieres añadir legibilidad)
          target: `/blog/${p.id}`,
        }));

        console.log("mapped posts:", mapped); // <- depuración

        setEntries(
          mapped.length
            ? mapped
            : [
                {
                  id: "fallback",
                  title: "Bienvenidos a ReWorld",
                  description: "ReWorld es un servidor de Hytale...",
                  image:
                    "https://cdn.hytale.com/5e7ba4723c9a2a001067939c_110___kweebec_leaf_ranger.jpg",
                  date: "23/11/2025",
                  type: "Release",
                  target: "/blog/bienvenidos-a-reworld",
                },
              ]
        );
      } catch (err) {
        console.error("Error cargando posts:", err);
        // fallback local
        setEntries([
          {
            id: "fallback",
            title: "Bienvenidos a ReWorld",
            description: "ReWorld es un servidor de Hytale...",
            image:
              "https://cdn.hytale.com/5e7ba4723c9a2a001067939c_110___kweebec_leaf_ranger.jpg",
            date: "23/11/2025",
            type: "Release",
            target: "/blog/bienvenidos-a-reworld",
          },
        ]);
      }
    }

    fetchPosts();
  }, []);

  return (
    <>
      <Header />
      <main className="blog__main">
        <div className="title__container">
          <h1>Blog</h1>
        </div>
        <hr />

        <div className="blog__container">
          {entries.map((entry) => (
            <BlogMiniature
              title={entry.title}
              description={entry.description}
              image={entry.image}
              date={entry.date}
              type={entry.type}
              target={entry.target}
              key={entry.id ?? entry.target} // usar id como key
            />
          ))}
        </div>
      </main>
      <Footer />
    </>
  );
}
// ...existing code...
