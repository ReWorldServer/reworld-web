import '../styles/App.css'
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Home from "../pages/Home.jsx";
import Blog from "../pages/Blog.jsx";
import Shop from "../pages/Shop.jsx";
import BlogEntry from "./BlogEntry.jsx";

function App() {
  return (
    <Router>
        <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/blog" element={<Blog />}/>
            <Route path="/blog/bienvenidos-a-reworld" element={<BlogEntry id="bienvenidos-a-reworld" />} />
            <Route path="/shop" element={<Shop />}/>
        </Routes>
    </Router>
  )
}

export default App
