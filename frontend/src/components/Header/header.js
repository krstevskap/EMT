import React from "react";

const header = (props) => {
    return (
        <nav className="navbar navbar-expand-md navbar-dark navbar-fixed bg-dark">
            <a className="navbar-brand" href="/books" style={{marginLeft: 15}}>Library Application</a>
            <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse"
                    aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                <span className="navbar-toggler-icon"></span>
            </button>
            <div className="collapse navbar-collapse" id="navbarCollapse">
                <ul className="navbar-nav mr-auto">
                    <li className="nav-item active">
                        <a className="nav-link" href="/books">Books</a>
                    </li>
                    <li className="nav-item active">
                        <a className="nav-link" href="/categories">Categories</a>
                    </li>
                    <li className="nav-item active">
                        <a className="nav-link" href="/countries">Countries</a>
                    </li>
                    <li className="nav-item active">
                        <a className="nav-link" href="/authors">Authors</a>
                    </li>
                </ul>
            </div>
        </nav>
    )
}
export default header;