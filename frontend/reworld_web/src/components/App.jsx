import "../styles/App.css";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Home from "../pages/Home.jsx";
import Blog from "../pages/Blog.jsx";
import Shop from "../pages/Shop.jsx";
import BlogEntry from "./BlogEntry.jsx";
import WorkInProgress from "../pages/WorkInProgress.jsx";

/* <Route path="/" element={<Home />} />}
        <Route path="/blog" element={<Blog />} />

        <Route path="/blog/:id" element={<BlogEntry />} />

        <Route path="/shop" element={<Shop />} />

        */

function App() {
  return (
    <Router>
      <Routes>

          <Route path="/" element={<WorkInProgress />} />
      </Routes>
    </Router>
  );
}

export default App;
