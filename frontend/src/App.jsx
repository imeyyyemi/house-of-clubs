import React, { useState, useEffect } from 'react';
import Login from './components/Login';
import Register from './components/Register';
import TodoList from './components/TodoList';
import api from './util/api';

function App() {
  const [user, setUser] = useState(null);
  const [isRegister, setIsRegister] = useState(false);

  useEffect(() => {
    const token = localStorage.getItem('token');
    if (token) {
      api.get('/me').then(res => setUser(res.data)).catch(() => localStorage.removeItem('token'));
    }
  }, []);

  const handleAuth = (credentials, isRegister) => {
    const endpoint = isRegister ? '/register' : '/login';
    api.post(endpoint, credentials).then(res => {
      localStorage.setItem('token', res.data.token || 'loggedin');
      setUser(res.data);
    }).catch(err => console.error(err));
  };

  const handleLogout = () => {
    api.post('/logout').then(() => {
      localStorage.removeItem('token');
      setUser(null);
    });
  };

  return (
   
        <div className="max-w-md mx-auto">
          <button onClick={() => setIsRegister(!isRegister)} className="mb-4 px-4 py-2 bg-blue-500 text-white rounded">
            {isRegister ? 'Login' : 'Register'}
          </button>
          {isRegister ? <Register onSubmit={(creds) => handleAuth(creds, true)} /> : <Login onSubmit={(creds) => handleAuth(creds, false)} />}
        </div>
      )}
    </div>
  );
}

export default App;
