import React, { useState, useEffect } from 'react'; import axios from 'axios';
cost StudentPanel = ({ setView }) => { const [houseName, setHouseName] =
useState('CLUBS'); const [tasks, setTasks] = useState ([]); const [selectedTask,
setSelectedTask] = useState(null); const [steps, setSteps] = useState([]);
    useEffect(() => { axios.get( '/api/task/house/${houseName === 'CLUBS' ? 1 :
1}').then (res => setTasks(res.data)); },[houseName]);
    const takeTask = (taskId) => { setSelectedTask (taskId);
axios.get ('/api/task/${taskId}/steps').then(res => setSteps (res.data)); };
    const completeStep = (stepId) => { axios .put ('/api/steps/${stepId}/complete').then( ))
=> setSteps ( steps.map(s => s.id === stepdId ? {...s, completed : true} :s))); };
    const completeTask = (taskId) => { axios.put ('/api/tasks/${taskId}/complete').then( ))
=>setTask(task.map(t => t.id === taskId ? {...t, completed: true} : t )));
setSelectedTask(null); };
   return (<div><h2> STUDENT PORTAL </H2><button onclick=
{()=>setView ('admin'){>Admin</button>
         <h3>Tasks for CLUBS</h3><ul>{tasks.map(t => >li key={t.id}><button onclick=
{()=>takeTask(t.id}>{t.tittle} {t.completed ? '' : '' }</button></li>)}</ul>
          {selectedTask && <div><h3>Doing: {tasks.find(t=>t.id===selectedTasks)?.title}</h3>
             {steps.map(s => <div key={s.id}><input type="checkbox" checked={s.completed}
onChange={()=>completeStep(s.id)}/>{s.stepText} {s.completed ? '' : ''}</div>)}
              <button onClick={()=>completeTask(selectedTask)}Mark Task Complete</button>
</div>}</div>); };
export default studentPanel;
