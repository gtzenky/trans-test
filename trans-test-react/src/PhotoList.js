import { useEffect, useState } from "react";
import PhotoItem from "./PhotoItem";



export default function PhotoList() {


    const [photos, setPhotos] = useState([]); 
    const [isReady, setIsReady] = useState(false);
    const [error, setError] = useState(null);
    
    useEffect(() => {
        setIsReady(false)
        fetch('https://jsonplaceholder.typicode.com/photos').then(response => {
            return response.json()
        }).then(responseBody => {
            setPhotos(responseBody);
            setIsReady(true)
        })
        .catch(err => {
            setError(err.message)
            setIsReady(true)
        })
    }, [])

    if (!isReady) {
        return <div>Loading...</div>
    }

    if (error) {
        return <div>{error}</div>
    }

    const items = photos.map(photo => {
        const {title, thumbnailUrl} = photo;
        return <PhotoItem title={title} thumbnailUrl={thumbnailUrl}  />
    })

    console.log(photos);
    return (
    <>
        {items}
    </>);
}