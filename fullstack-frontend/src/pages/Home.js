import React, { useEffect , useState } from 'react'
import axios from 'axios'

export default function Home() {
  const [users , setUsers] = useState([]);
  // initial state is empty array and setUsers is a function to update the state
  // [] is an array of users

  useEffect(() => {
    loadUsers()
    // [] is the dependency array which means that the function will only run once when the component loads
    // [] stores the values of the variables that are used in the function
    // if you want to run the function again when the component loads then you can remove the dependency array
  },[]); // a dependency array is used to run the function only once when the component loads

  

  const loadUsers =async() =>{
      const result = await axios.get("http://localhost:8080/users")
     setUsers(result.data)
  }
  return (
    <div className="container">
        <div className="py-4">
        <table className="table border shadow">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Username</th>
      <th scope="col">Name</th>
      <th scope="col">Email</th>
      <th scope={"col"}>Action</th>
    </tr>
  </thead>
  <tbody>

    {
      users.map((user,index) =>(
      <tr>
      <th scope="row" key={index}>{index+1}</th>
      <td>{user.userName}</td>
      <td>{user.name}</td>
      <td>{user.email}</td>
        <td>
          <button className={"btn btn-primary mx-2"}> View </button>
          <button className={"btn btn-outline-primary mx-2"}> View </button>
          <button className={"btn btn-danger mx-2"}> View </button>
        </td>
    </tr>
      ))
    }

  </tbody>
</table>
        </div>
    
    
    </div>
  )
}
