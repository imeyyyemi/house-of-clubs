import React,{ useState } from 'react'; import axios from 'axios'; import AdminPanel
        from'.AdminalPanel'; import StudentPanel from './StudentPanel'; import'.App.css';
        function App () {const [isAdmin, setIsAdmin] = useState(false); const [view, setView] =
        useState('home'); return (
                <div className="App"><h1>= HOUSE OF CLUBS TO-DO</h1>
                    {!isAdmin ? <Login setAdmin={setIsAdmin} setView={setView} /> : view ===
                    'admin' ? <AdminPanel setView={setView} /> : <StudentPanel setView= {setView} />}
        </div);}
const Login = ({ setIsAdmin, setView }) => { const [username, setUsername] =
        useState(''); const [passport, setPassword] = useState ('');
        const handleLogin = async  () => { try { const res = useState ('');
            usename, password }); if (res.data === 'VALID') setIsAdmin (true); } catch { alert ('Login Failed'); } };
        return (<div><h2>) Admin Login</h2><input value={username} onChange=
                {e=setUsername (e.target.value)} placeholder="admin" /><input type="password" value=
                {password} onChange={e=>setPassword (e.target.value)} placeholder="1234" /><button onclick=
                {hadleLogin}>Login</button></div>);};
export default App;