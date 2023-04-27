import './App.css';
import React, {Component} from "react";
import Books from "../Books/BookList/books";
import Countries from "../Countries/countries";
import Authors from "../Authors/AuthorList/authors";
import LibraryService from "../../repository/libraryRepository";
import Categories from "../Categories/categories";
import Header from "../Header/header";
import {BrowserRouter as Router, Route, Redirect} from 'react-router-dom';
import BookAdd from "../Books/BookAdd/bookAdd";
import BookEdit from "../Books/BookEdit/bookEdit";
import BookMark from "../BookMark/bookMark";

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            books: [],
            countries: [],
            authors: [],
            categories: [],
            selectedBook: {}
        }
    }

    render() {
        return (
            <Router>
                <main>
                    <Header/>
                    <div className={"container"}>

                        <Route path={"/countries"}
                               exact render={() => <Countries countries={this.state.countries}/>}
                        />

                        <Route path={"/categories"}
                               exact render={() => <Categories categories={this.state.categories}/>}
                        />

                        <Route path={"/authors"}
                               exact render={() => <Authors authors={this.state.authors}/>}
                        />

                        <Route path={"/books"}
                               exact render={() => <Books books={this.state.books}
                                                          onDelete={this.deleteBooks}
                                                          onEdit={this.getBook}
                                                          onMarkAsTaken={this.markAsTaken}/>}
                        />

                        <Route path={"/books/add"}
                               exact render={() => <BookAdd categories={this.state.categories}
                                                            authors={this.state.authors}
                                                            onAddBook={this.addBook}/>}
                        />

                        <Route path={"/books/edit/:id"}
                               exact render={() =>
                                <BookEdit authors={this.state.authors}
                                          categories={this.state.categories}
                                          onEditBook={this.editBook}
                                          getBook={this.getBook}
                                          book={this.state.selectedBook}
                                />
                        }/>

                        <Route path={"/books/mark/:id"}
                               exact render={() =>
                                <BookMark book={this.state.selectedBook}
                                          getBook={this.getBook}
                                          onMarkAsTaken={this.markAsTaken}
                                />
                        }/>
                        <Route exact path="/books">
                            <Redirect to={"/books"}/>
                        </Route>
                    </div>
                </main>
            </Router>

        );
    }

    loadBooks = () => {
        LibraryService.fetchBooks()
            .then((data) => {
                this.setState({
                    books: data.data
                })
            });
    }

    loadAuthors = () => {
        LibraryService.fetchAuthors()
            .then((data) => {
                this.setState({
                    authors: data.data
                })
            });
    }
    loadCountries = () => {
        LibraryService.fetchCountries()
            .then((data) => {
                this.setState({
                    countries: data.data
                })
            });
    }

    loadCategories = () => {
        LibraryService.fetchCategories()
            .then((data) => {
                this.setState({
                    categories: data.data
                })
            });
    }

    deleteBooks = (id) => {
        LibraryService.deleteBooks(id)
            .then(() => {
                this.loadBooks();
            });
    }

    addBook = (name, category, author, availableCopies) => {
        LibraryService.addBook(name, category, author, availableCopies)
            .then(() => {
                this.loadBooks();
            });
    }

    getBook = (id) => {
        LibraryService.getBook(id)
            .then((data) => {
                this.setState({
                    selectedBook: data.data
                })
            })
    }


    markAsTaken=(id)=>{
        LibraryService.markAsTaken(id)
            .then(() => {
                this.loadBooks();
            });
    }

    editBook = (id, name, category, author, availableCopies) => {
        LibraryService.editBook(id, name, category, author, availableCopies)
            .then(() => {
                this.loadBooks();
            });
    }

    componentDidMount() {
        this.loadBooks();
        this.loadCountries();
        this.loadCategories();
        this.loadAuthors();
    }
}

export default App;
