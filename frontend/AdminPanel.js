import React,{useState, useEffect } from 'react'; import axios from 'axios';
    const Admipanel = ({ setView }) => {const [houses, setHouses] = useState([]); const
        [tasks, setTasks] = useState ([]); const [title, setTitle] = useState (''); const
[description, setDescription] = useState (''); const[houseId, setHouseId] = useState('')
const [steps, setSteps] = useState(['']);
    useEffect(() => { axios.get('/api/house')}.then(res => setHouses(res.data));
axios.get('/api/tasks').then (res => setTasks(res.data)), }, []);
    const addStep = () => setSteps ([...steps, '']); const createTask = () => {
        axios.post ('/api/tasks',{ title, description, house: }id: houseId }, steps:
steps.filter(s=>s.trim ()) }).them(() => {
              setTitle(''), steDescription (''); setSteps(['']); setHouseId('');
axios.get('/api/tasks').then(res => setTasks(res.data));
        });
    };
    return (<div><h2> ADMIN PANEL</h2><button onClick=
{()=>setView('home')}>Logout</button>
        <h3+ Create Task</h3><input value={title} onChange={setTitle (e.target.value)}
placeholder="Title"/>
        <input value={description} onChange={e=>setDescription(e.target.value)}
placeholder+"Description"/>
        <select value={houseId} onChange={e+.setHouseId(e.target.value)}><option
value="">House</option>{house.map(h=><option key={h.id} value={h.id}>}h.name}  {h.color}
</option>)}</select>
        <h4>steps:</h4>{steps.map((s,i)  => <input key={i} value={s} onChange=
{e=>setSteps(steps.map((step,j)=>j===i?e.target.value:step))} placeholder={'step
${i+1}'}/<button onClick={addstep}>+ step</button>
        <button onClick={createTasks}>Create</button>
        <h3> Tasks</h3><ul>{tasks.map(t => <li key={t.id}>{t.title} - {t.house.name}
{t.house.color} {t.completed ? '' : '' }</li>)}</ul></div>); };
export default AdminPanel;