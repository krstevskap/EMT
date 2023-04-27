import React, {useEffect} from 'react';
import {useHistory, useParams} from 'react-router-dom';

const BookMark = (props) => {
    const history = useHistory();
    const {id} = useParams();

    useEffect(() => {
        props.getBook(id);
    }, [])
    const onClick = () => {
        props.onMarkAsTaken(props.book.id);
        history.push("/books");
    }

    return (
        <>
            {props.book.availableCopies !== 0 ? (
                <div style={{textAlign: "center", marginTop: "150" + 'px'}}>
                    <h3 className="display-3">Mark book: <b>{props.book.name}</b></h3>
                    <p>Are you sure you want to mark this book?</p>
                    <button type="button"
                            onClick={onClick}
                            className="btn btn-outline-success">
                        Mark
                    </button>
                    <a style={{marginLeft: 10 + "px"}}
                       type="button"
                       className={"btn btn-outline-primary"}
                       href="/books">
                        Back
                    </a>

                </div>
            ) : (
                <div style={{textAlign: "center", marginTop: "150" + 'px'}}>
                    <h3 className="display-3">There are no available copies of <b>{props.book.name}</b>.</h3>
                    <a type="button"
                       className={"btn btn-outline-primary"}
                       href="/books">
                        Back
                    </a>
                </div>
            )
            }
        </>
    );
}
export default BookMark;