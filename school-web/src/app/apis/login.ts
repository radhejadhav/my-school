import axios from "axios"

export const login =async ()=>{
    return await axios.get("http://localhost:8008/users/find-all",{headers:{
        Authorization:"Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyYWRoZWphZGhhdiIsImlhdCI6MTY3NTE4NzYxNiwiZXhwIjoxNjc1Mjc0MDE2fQ.107uBtv6dpebHRUDHIx1wJ2vmsGtw-tK1nvfLw3vdfY"
    }}).then(res=>{
        // console.log(res.data);
        return res.data
    }).catch(err=>err);
}