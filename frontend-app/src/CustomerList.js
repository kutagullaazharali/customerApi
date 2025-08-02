import React, { useState } from "react";

const SearchCustomer = () => {
  const [filterType, setFilterType] = useState("id"); // default
  const [query, setQuery] = useState("");
  const [customer, setCustomer] = useState(null);
  const [error, setError] = useState("");

  const handleSearch = async () => {
    let url = "http://localhost:8080/api/customers";

    if (filterType === "id") {
      url += `/${query}`;
    } else if (filterType === "name") {
      url += `/name/${query}`;
    } else if (filterType === "email") {
      url += `/email/${query}`;
    }

    try {
      const response = await fetch(url);
      if (!response.ok) throw new Error("Customer not found");

      const data = await response.json();
      setCustomer(data);
      setError("");
    } catch (err) {
      setCustomer(null);
      setError(err.message);
    }
  };

  return (
    <div className="p-6 max-w-xl mx-auto">
      <h2 className="text-xl font-bold mb-4">Search Customer</h2>

      <div className="mb-4">
        <select
          value={filterType}
          onChange={(e) => setFilterType(e.target.value)}
          className="border px-3 py-2 mr-2"
        >
          <option value="id">Search by ID</option>
          <option value="name">Search by Name</option>
          <option value="email">Search by Email</option>
        </select>

        <input
          type="text"
          placeholder={`Enter ${filterType}`}
          value={query}
          onChange={(e) => setQuery(e.target.value)}
          className="border px-3 py-2 mr-2"
        />

        <button
          onClick={handleSearch}
          className="bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-600"
        >
          Search
        </button>
      </div>

      {error && <p className="text-red-500">{error}</p>}

      {customer && (
        <div className="mt-4 border p-4 rounded bg-gray-100">
          <p><strong>ID:</strong> {customer.id}</p>
          <p><strong>Name:</strong> {customer.name}</p>
          <p><strong>Email:</strong> {customer.email}</p>
        </div>
      )}
    </div>
  );
};

export default SearchCustomer;
