import React, { useState } from 'react';

const Dashboard = () => {
  const [items, setItems] = useState([]);
  const [formData, setFormData] = useState({ name: '', description: '' });
  const [editIndex, setEditIndex] = useState(null);

  // Handle input changes
  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  // Create or Update item
  const handleSubmit = (e) => {
    e.preventDefault();
    if (editIndex !== null) {
      const updatedItems = [...items];
      updatedItems[editIndex] = formData;
      setItems(updatedItems);
      setEditIndex(null);
    } else {
      setItems([...items, formData]);
    }
    setFormData({ name: '', description: '' });
  };

  // Edit item
  const handleEdit = (index) => {
    setFormData(items[index]);
    setEditIndex(index);
  };

  // Delete item
  const handleDelete = (index) => {
    const updatedItems = items.filter((_, i) => i !== index);
    setItems(updatedItems);
  };

  return (
    <div style={{ padding: '2rem' }}>
      <h2>📊 Dashboard with CRUD</h2>

      <form onSubmit={handleSubmit} style={{ marginBottom: '1rem' }}>
        <input
          type="text"
          name="name"
          placeholder="Name"
          value={formData.name}
          onChange={handleChange}
          required
        />
        <input
          type="text"
          name="description"
          placeholder="Description"
          value={formData.description}
          onChange={handleChange}
          required
        />
        <button type="submit">{editIndex !== null ? 'Update' : 'Add'}</button>
      </form>

      <ul>
        {items.map((item, index) => (
          <li key={index}>
            <strong>{item.name}</strong>: {item.description}
            <button onClick={() => handleEdit(index)}>✏️ Edit</button>
            <button onClick={() => handleDelete(index)}>🗑️ Delete</button>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default Dashboard;