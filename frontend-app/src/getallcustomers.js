import React, { useState } from 'react';

export default function GetAllCustomers() {
  const [customers, setCustomers] = useState([]);
  const [loading, setLoading] = useState(false);

  const fetchCustomers = () => {
    setLoading(true);
    fetch("http://localhost:8080/api/customers")
      .then(response => response.json())
      .then(data => {
        setCustomers(data);
        setLoading(false);
      })
      .catch(err => {
        // console.error("Error fetching customers:", err);
        setLoading(false);
      })
  };

  return (
    <div>
      <h2>All Customers</h2>
      <button onClick={fetchCustomers}>Get Customers</button>
      <br /><br />

      {loading && <p>Loading...</p>}

      {/* Show table only if customers exist */}
      {/* {console.log(customers,"All the customers data")} */}
      {customers.length > 0 && (
        
        <table border="1">
          <thead>
            <tr>
              <th>ID</th><th>Name</th><th>Email</th><th>Address</th><th>Role</th><th>username</th><th>createdAt</th>
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
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
}
