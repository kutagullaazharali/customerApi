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
      .catch(error => {
        console.error("Error fetching customers:", error);
        setLoading(false);
      });
  };

  return (
    <div>
      <h2>All Customers</h2>
      <button onClick={fetchCustomers}>Get Customers</button>
      <br /><br />

      {loading && <p>Loading...</p>}

      {/* Show table only if customers exist */}
      {customers.length > 0 && (
        <table border="1">
          <thead>
            <tr>
              <th>ID</th><th>Name</th><th>Email</th><th>Address</th>
            </tr>
          </thead>
          <tbody>
            {customers.map(customer => (
              <tr key={customer.user_id}>
                <td>{customer.user_id}</td>
                <td>{customer.name}</td>
                <td>{customer.email}</td>
                <td>{customer.address}</td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
}
