import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';

// Functional component (React Component)
function SignUpForm() {
  // useNavigate is from React Router to programmatically navigate pages
  const navigate = useNavigate();

  // useState hook to manage form data (React State)
  const [formData, setFormData] = useState({
    name: '',
    username: '',
    email: '',
    password: '',
    address: '',
    role: 'USER', // default value for role
  });

  // handleChange updates the state when user types in the input (Event Handling)
  const handleChange = (e) => {
    // Spread operator (...) keeps existing state and updates the changed field
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  // handleSubmit handles form submission (Event Handling + API Call)
  const handleSubmit = async (e) => {
    e.preventDefault(); // Prevent default HTML form submission (page reload)

    // Prepare data to send to backend
    const dataToSend = {
      ...formData,
      createdAt: new Date().toISOString(), // current timestamp in ISO format
    };

    try {
      // Fetch API call to backend (HTTP Request)
      const response = await fetch('http://localhost:8080/api/customers', {
        method: 'POST', // HTTP POST method
        headers: { 'Content-Type': 'application/json' }, // JSON header
        body: JSON.stringify(dataToSend), // Convert JS object to JSON string
      });

      if (response.ok) {
        alert('User created successfully!'); // Success message
        navigate('/'); // Redirect to Login page (React Router)
        // Reset form fields
        setFormData({ name: '', username: '', email: '', password: '', address: '', role: 'USER' });
      } else {
        alert('Error creating user'); // Error handling
      }
    } catch (error) {
      console.error(error);
      alert('Something went wrong'); // Catch network or unexpected errors
    }
  };

  return (
    <div style={{ maxWidth: '400px', margin: 'auto' }}>
      {/* JSX (HTML inside JS) */}
      <h2>Sign Up</h2>
      <form onSubmit={handleSubmit}>
        {/* Controlled Components - input values are tied to React state */}
        <input
          type="text"
          name="name"
          placeholder="Name"
          value={formData.name}
          onChange={handleChange} // Event handling
          required
        /><br /><br />
        
        <input
          type="text"
          name="username"
          placeholder="Username"
          value={formData.username}
          onChange={handleChange}
          required
        /><br /><br />

        <input
          type="email"
          name="email"
          placeholder="Email"
          value={formData.email}
          onChange={handleChange}
          required
        /><br /><br />

        <input
          type="password"
          name="password"
          placeholder="Password"
          value={formData.password}
          onChange={handleChange}
          required
        /><br /><br />

        <input
          type="text"
          name="address"
          placeholder="Address"
          value={formData.address}
          onChange={handleChange}
        /><br /><br />

        {/* Button triggers form submission */}
        <button type="submit">Sign Up</button>
      </form>
    </div>
  );
}

export default SignUpForm;
