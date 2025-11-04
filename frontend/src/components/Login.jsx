import React, { useState } from 'react';

const Login = ({ onSubmit }) => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    onSubmit({ username, password });
  };

  return (
   <form onSubmit={handleSubmit} className="space-y-4">
       <input
       type="text"
       value={username}
       onChange={(e) => setUsername(e.target.value)}
       placeholder="Username"
       className="w-full p-2 border rounded"
       required
       />
       <input
          type="password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          placeholder="Password"
          className="w-full p-2 border rounded"
          required
          />
          <button type="submit" className="w-full p-2 bg-blue-500 text-white rounded">
              Login
              </button>
              </form>
  );
};

export default Login;
