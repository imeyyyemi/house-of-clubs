import React,{ useState } from 'react'; import axios from 'axios'; import AdminPanel
        from'./AdminalPanel'; import StudentPanel from './StudentPanel'; import'./App.css';
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

import React,{useState, useEffect } from 'react'; import axios from 'axios';
    const Admipanel = ({ setView }) => {const [houses, setHouses] = useState([]); const
        [tasks, setTasks] = useState ([]); const [title, setTitle] = useState (''); const
[tasks, setTasks] =useState ([]); const [title, setTitle] = useState(''); useState ('');
const [steps, setSteps] = useState(['']);
useEffect(() => {axios.get ('/api/houses').then(res => setHouses (res.data));
    axios.get('/api/tasks').then (res => setTasks (res.data));}, []);
const addStep = () => setSteps ([...steps, '']); const createTask = () => {
    axios.post('/api/tasks', {title, description, house: id: houseId }, steps:
                steps.filter(s=>s. trim()) }). then (() => {
                    setTitle (''), setDescription(''); setSteps (['']); setHouseId('');
                    axios.get('/api/tasks'). then (res => setTasks (res.data));
                });
         };
    return (<div><h2> ADMIN PANEL</h2><button onClick=
                {()=setView('home')}Logout</button>
        <h3>+ Create Task<h3><input value={title} onChange={e=>setTitle (e.target.value)}
        placeholder="Title"/>
        <input value={description} onChange={e=>setDescription(e.terget.value)}
        placeholder="Description"/>
        <select value={houseId} onChange={e=>setDescription(e.target.value)}><option}
        value="">House</option?{houses.map(h=><option key={h.id} value)}>{h.name} {h.color}
        </option>)}</select>
        <h4>steps:</h4>{steps.map((s,i) => input key={i} value={s} onChange=
                {e=>setSteps (steps.map((step,j)=>j===i?e.target.value:step))} placeholder={'step
        ${i+1}'}/>)}<button onClick={addStep}>+ step</button>
        <button onClick={createTask}>create</button>
        <h3> Tasks</h3><ul>{task.map(t => <li key={t.id}>{t.title} - {t.house.name}
            {t.house.color} {t.completed ? ' ' : '' }</li>)}</ul></div); };
        export default AdminPanel;

        import React, { useState, useEffect } from 'react'; import axios from 'axios';
    const StudentPanel = ({ setView }) => { const [houseName, setHouseNme] =
        useState ('CLUBS'); const [task, setTasks] = useState ([]); const [selectedTask,
        setSelectedTask] =useState (null); const [setps, setSteps] = useState ([]);
            useEffect (() => { axios.get ('/api/tasks/house/${houseName === 'CLUBS' ? 1 :
        1}').then (res => setTasks (res.data)); }, [houseName];
            const takeTask = (taskId) => { setSelectedTask (taskId);
        axios.get('/api/tasks/${taskId}/steps').then (res => setSteps (res.date)); };
            const completeStep = (stepId) => { axios.put('/api/steps/${stepId}/complete'). thhen(()
        => setSteps (steps.map(s => t.id === stepId ? {...s, completed: true} : s))); };
            const completeTask = (taskId) => { axios.put ('/api/tasks/${taskId}/complete').then(()
        => setTasks (tasks.map(t .id === taskId ? {...t, completed: true} : t)));
        setSelectedTask(Null), };
            return (<div><h2> STUDENT PORTAL</h2><button onClick=
                {()=>setView('admin')}>Admin</button>
        <h3>Tasks for CLUBS</h3><ul>{tasks.map(t => <li key={t.id}><button onClick=
                {()=> takeTask (t.id)}>{t.title} {t.completed ? ' ' : ' ' }</button></li>)}</ul>
                {selectedTask && <div><h3>Doing: {tasks.find(t=>t.id===selectedTask)?.tittls}</h3>
                   {steps.map(s => <div key={s.id}><input type="checkbox" checked={s.completed}
        onChange={()=>completeStep(s.id)}/>{s.stepText} {s.completed ? '' : ' }</div>)'}
                    <button onClick={()=> completeTask(selectedTask)}>Mark Task Complete</Button>
        </div>}</div>); };
        export default StudentPanel;

        .App {text-align: center; padding: 20px; } input, select, button {margin: 5px;  padding:
        8px } ul{ list-style: none; } li { margin: 10px; }




















