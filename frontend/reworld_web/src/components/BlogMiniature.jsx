import "../styles/BlogMiniature.css"
import {Link} from "react-router-dom";

export default function BlogMiniature({image, title, description, date, type, target}) {
    return (
        <Link className="blog-miniature" to={target}>
            <img src={image} alt={title} className="blog-miniature__image" />
            <div className="blog-miniature__content">
                <h2>{title}</h2>
                <p className="blog-miniature__metadata">
                    <span>{date} </span>
                    -
                    <span className={`type__${type}`}> {type}</span>
                </p>
                <p className="blog-miniature__description">{description}</p>
            </div>
        </Link>
    )
}