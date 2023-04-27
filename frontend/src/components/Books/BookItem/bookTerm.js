import React from "react";

const bookTerm = (props) => {
    return (
        <tr>
            <td scope={"col"}>{props.term.name}</td>
            <td scope={"col"}>{props.term.category}</td>
            <td scope={"col"}>{props.term.author.name}</td>
            <td scope={"col"}>{props.term.author.surname}</td>
            <td scope={"col"}>{props.term.availableCopies}</td>
            <td scope={"col"} className={"text-right"}>

                <a style={{marginRight: 10 + 'px'}}
                   title={"Delete"}
                   className={"btn btn-danger"}
                   onClick={() => props.onDelete(props.term.id)}>
                    Delete
                </a>

                <a style={{marginRight: 10 + 'px'}}
                   type="button"
                   className={"btn btn-info ml-2"}
                   onClick={() => {
                       props.onEdit(props.term.id)
                   }}
                   href={`/books/edit/${props.term.id}`}>
                    Edit
                </a>

                <a type="button"
                   id="mark"
                   className={"btn btn-success ml-2"}
                   onClick={() => {
                       props.onMarkAsTaken(props.term.id)
                   }}
                   href={`/books/mark/${props.term.id}`}>
                    Mark as taken
                </a>
            </td>
        </tr>
    )
}

export default bookTerm;