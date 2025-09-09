import React, { useState } from 'react';
import { useNavigate } from "react-router-dom";
import axios from "axios"; 

export default function GetAllCustomers() {
  const [customers, setCustomers] = useState([]);
  const [loading, setLoading] = useState(false);
  const navigate = useNavigate();

  const fetchCustomers = () => {
    setLoading(true);
    fetch("http://localhost:8080/api/customers")
      .then(response => response.json())
      .then(data => {
        setCustomers(data);
        setLoading(false);
      })
      .catch(err => {
        setLoading(false);
        console.error("Error fetching customers:", err);
      });
  };

  const deleteUser = (id) => {
    axios.delete(`http://localhost:8080/api/customers/id/${id}`) // match your backend
      .then(() => fetchCustomers())
      .catch(error => console.error("Delete error:", error));
  };

  return (
    <div>
      <h2>All Customers</h2>
      <button onClick={() => navigate("/loginComponent")}>Back</button>
      <button onClick={fetchCustomers}>Get Customers</button>
      <br /><br />
      {loading && <p>Loading...</p>}

      {customers.length > 0 && (
        <table border="1">
          <thead>
            <tr>
              <th>ID</th><th>Name</th><th>Email</th><th>Address</th>
              <th>Role</th><th>Username</th><th>CreatedAt</th><th>Delete</th>
            </tr>
          </thead>
          <tbody>
            {customers.map(customer => (
              <tr key={customer.user_id}>
                <td>{customer.user_id}</td>
                <td>{customer.name}</td>
                <td>{customer.email}</td>
                <td>{customer.address}</td>
                <td>{customer.role}</td>
                <td>{customer.username}</td>
                <td>{customer.createdAt}</td>
                <td>
                  <button onClick={() => deleteUser(customer.user_id)}>Delete</button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
}
