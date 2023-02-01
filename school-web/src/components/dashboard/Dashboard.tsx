import React, { useCallback, useEffect, useState } from "react";
import { login } from "app/apis/login";
import {
  Col,
  Row,
  FormControl,
  Button,
  ListGroup,
  ListGroupItem,
} from "react-bootstrap";
import { Outlet } from "react-router-dom";

const Dashboard = () => {
    const [users, setUsers] = useState([]);

    const loadUsers= useCallback(async()=>{
        const data = await login();
        if(data){
            setUsers(data.data)
        }
    },[])

    useEffect(()=>{   
        loadUsers()     
    }, [loadUsers])

  return (
    <Row>
      <Col className="shadow py-5" md={4}>
        <div className="d-block bordered px-4 gap-3">
          <div className="d-flex gap-1 justify-content-between">
            <FormControl placeholder="Search" className="w-75" />
            <Button>Search</Button>
          </div>
          <ListGroup className="mt-4 croll-y" variant="flush">
            {users.map((user:any)=>{
                return <ListGroupItem>{user?.username}</ListGroupItem>
            })}
          </ListGroup>
        </div>
        <div id="detail"></div>
      </Col>
      <Col className="shadow py-5" md={8}>
      <Outlet/>
      </Col>
    </Row>
  );
};

export default Dashboard;
