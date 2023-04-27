import React, {useEffect} from 'react';
import {useHistory, useParams} from 'react-router-dom';

const BookEdit = (props) => {
    const history = useHistory();
    const {id} = useParams();

    const [formData, updateFormData] = React.useState({
        name: "",
        category: "THRILLER",
        author: 0,
        availableCopies: 0
    })

    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        })
    }

    useEffect(() => {
        props.getBook(id);
    }, [])

    const onFormSubmit = (e) => {
        e.preventDefault();
        const name = formData.name !== "" ? formData.name : props.book.name;
        const category = formData.category !== "THRILLER" ? formData.category : props.book.category;
        const author = formData.author !== 0 ? formData.author : props.book.author.id;
        const availableCopies = formData.availableCopies !== 0 ? formData.availableCopies : props.book.availableCopies;

        props.onEditBook(props.book.id, name, category, author, availableCopies);
        history.push("/books");
    }

    return (
        <div className="row mt-5">
            <div className="col-md-5">
                <form onSubmit={onFormSubmit}>
                    <div className="form-group">
                        <label htmlFor="name">Book name</label>
                        <input type="text"
                               className="form-control"
                               id="name"
                               name="name"
                               placeholder={props.book.name}
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label>Category</label>
                        <select name="category" className="form-control" onChange={handleChange}>
                            {props.categories.map((term) => {
                                if (props.book.category === term)
                                    return <option selected={props.book.category} value={term}>{term}</option>
                                else return <option value={term.id}>{term}</option>
                            })}
                        </select>
                    </div>
                    <div className="form-group">
                        <label>Authors</label>
                        <select name="author" className="form-control" onChange={handleChange}>
                            {props.authors.map((term) => {
                                if (props.book.author !== undefined &&
                                    props.book.author.id === term.id) {
                                    console.log(term.name);
                                    return <option selected={props.book.author}
                                                   value={term.id}>{term.name} {term.surname}</option>
                                } else {
                                    return <option value={term.id}>{term.name} {term.surname}</option>
                                }
                            })}

                        </select>
                    </div>
                    <div className="form-group">
                        <label htmlFor="price">Available Copies</label>
                        <input type="text"
                               className="form-control"
                               id="availableCopies"
                               name="availableCopies"
                               placeholder={props.book.availableCopies}
                               onChange={handleChange}
                        />
                    </div>
                    <br/>
                    <button id="submit" type="submit" className="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    )
}

export default BookEdit;