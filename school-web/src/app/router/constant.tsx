import React from "react";
import AppLayout from "app/layout/AppLayout";
import Dashboard from "components/dashboard/Dashboard";
import NotFoundError from "components/error/NotFoundError";
import Homepage from "components/home/Homepage";
import Login from "components/login/Login";
import { RouteObject } from "react-router-dom";

export const routes:Array<RouteObject> = [
    {
        element:<AppLayout/>,
        errorElement:<NotFoundError/>,
        children:[
            {
                path:"/login",
                element: <Login/>,
            },
            {
                path:"/home",
                element: <Homepage/>,
            },
            {
                path:"",
                index:true,
                element:<Dashboard/>,
            }
        ]
    },

]