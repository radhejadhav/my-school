import React from 'react';
import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import { routes } from 'app/router/constant';
import 'App.css';

function App() {
  const router = createBrowserRouter(routes, {window:window});
  return (
      <>
      <RouterProvider 
      router={router} 
      fallbackElement 
      key={"_router_key"}/>
      </>
  );
}

export default App;
