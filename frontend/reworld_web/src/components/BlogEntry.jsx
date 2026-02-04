import Header from "./Header.jsx";
import Footer from "./Footer.jsx";
import { useState, useEffect } from "react";
import { useParams } from "react-router-dom";

function parseComponent(component) {
  if (!component || !component.type) return null;
  // your parsing logic here
}

export default function BlogEntry({ id: propId }) {
  const params = useParams();
  const routeId = params?.id;
  const id = propId ?? routeId;

  const [data, setData] = useState(null);

  useEffect(() => {
    if (!id) return;

    const maybeNumber = parseInt(String(id).split("-")[0], 10);
    const fetchUrl = !isNaN(maybeNumber)
      ? `http://backend.reworldhytale.com:8080/api/blogposts/${maybeNumber}`
      : `http://backend.reworldhytale.com:8080/api/blogposts/${id}`;

    fetch(fetchUrl)
      .then(async (res) => {
        if (!res.ok) throw new Error(`HTTP ${res.status}`);
        const json = await res.json();
        console.log("BlogEntry JSON:", json); // <-- depuración
        setData(json);
      })
      .catch((err) => {
        console.log("Error fetching blog entry:", err);
      });
  }, [id]);

  if (!data) return <p>Cargando...</p>;

  return (
    <>
      <Header />
      <main>
        <h1>{data.title}</h1>
        <p>{data.description}</p>
        {data.image && <img src={data.image} alt={data.title} />}
        <p>{data.datep && new Date(data.datep).toLocaleDateString("es-ES")}</p>
        {/* Si tu backend realmente devuelve un array "content", lo recorres aquí */}
        {Array.isArray(data.content) &&
          data.content.map((item, i) => (
            <span key={i}>{parseComponent(item)}</span>
          ))}
      </main>
      <Footer />
    </>
  );
}
