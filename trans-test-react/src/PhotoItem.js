import { useEffect, useState } from "react";



export default function PhotoItem({title, thumbnailUrl}) {

    return (
        <>
            <h4>{title}</h4>
            <img title={title} src={thumbnailUrl} />
        </>
    );
}