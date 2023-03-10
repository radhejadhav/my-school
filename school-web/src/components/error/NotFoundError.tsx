import React from 'react'
import { useRouteError } from 'react-router-dom';

const NotFoundError = () => {
    const error = useRouteError()??undefined;

  console.error(error);
  return (
    <div id="error-page">
      <h1>Oops!</h1>
      <p>Sorry, an unexpected error has occurred.</p>
      <p>
        {/* {error&&<i>{error?.statusText || error?.message}</i>} */}
      </p>
    </div>
  )
}

export default NotFoundError
