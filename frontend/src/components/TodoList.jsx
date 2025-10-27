import React, { useState, useEffect } from 'react';
import api from '../utils/api';

const TodoList = ({ userId }) => {
  const [tasks, setTasks] = useState([]);
  const [newTask, setNewTask] = useState({ title: '', description: '' });
  const [editingId, setEditingId] = useState(null);
  const [editTask, setEditTask] = useState({ title: '', description: '', completed: false });

  useEffect(() => {
    fetchTasks();
  }, []);

  const fetchTasks = () => {
    api.get('/tasks').then(res => setTasks(res.data)).catch(err => console.error(err));
  };

  const handleAddTask = (e) => {
    e.preventDefault();
    api.post('/tasks', newTask).then(() => {
      setNewTask({ title: '', description: '' });
      fetchTasks();
    });
  };

  const handleEditTask = (task) => {
    setEditingId(task.id);
    setEditTask({ title: task.title, description: task.description, completed: task.completed });
  };

  const handleUpdateTask = (e) => {
    e.preventDefault();
    api.put(`/tasks/${editingId}`, editTask).then(() => {
      setEditingId(null);
      fetchTasks();
    });
  };

  const handleDeleteTask = (id) => {
    api.delete(`/tasks/${id}`).then(() => fetchTasks());
  };

  const handleToggleComplete = (id, completed) => {
    const task = tasks.find(t => t.id === id);
    api.put(`/tasks/${id}`, { ...task, completed }).then(() => fetchTasks());
  };

  return (
    <div className="space-y-4">
      <h2 className="text-2xl font-bold">My Tasks</h2>
      <form onSubmit={handleAddTask} className="space-y-2">
        <input
          type="text"
          value={newTask.title}
          onChange={(e) => setNewTask({ ...newTask, title: e.target.value })}
          placeholder="Title"
          className="w-full p-2 border rounded"
          required
        />
        <input
          type="text"
          value={newTask.description}
          onChange={(e) => setNewTask({ ...newTask, description: e.target.value })}
          placeholder="Description"
          className="w-full p-2 border rounded"
        />
        <button type="submit" className="p-2 bg-blue-500 text-white rounded">
          Add Task
        </button>
      </form>
      <ul className="space-y-2">
        {tasks.map(task => (
          <li key={task.id} className="border p-2 rounded">
            {editingId === task.id ? (
              <form onSubmit={handleUpdateTask} className="space-y-2">
                <input
                  type="text"
                  value={editTask.title}
                  onChange={(e) => setEditTask({ ...editTask, title: e.target.value })}
                  className="w-full p-1 border rounded"
                  required
                />
                <input
                  type="text"
                  value={editTask.description}
                  onChange={(e) => setEditTask({ ...editTask, description: e.target.value })}
                  className="w-full p-1 border rounded"
                />
                <input
                  type="checkbox"
                  checked={editTask.completed}
                  onChange={(e) => setEditTask({ ...editTask, completed: e.target.checked })}
                  className="mr-2"
                />
                <button type="submit" className="p-1 bg-green-500 text-white rounded mr-2">
                  Save
                </button>
                <button type="button" onClick={() => setEditingId(null)} className="p-1 bg-gray-500 text-white rounded">
                  Cancel
                </button>
              </form>
            ) : (
              <div className="flex items-center">
                <h3 className="font-semibold">{task.title}</h3>
                <p className="ml-4 text-gray-600">{task.description}</p>
                <input
                  type="checkbox"
                  checked={task.completed}
                  onChange={(e) => handleToggleComplete(task.id, e.target.checked)}
                  className="ml-4 mr-2"
                />
                <span className={task.completed ? 'line-through text-gray-500' : ''}>
                  {task.completed ? 'Completed' : 'Pending'}
                </span>
                <button onClick={() => handleEditTask(task)} className="ml-4 p-1 bg-yellow-500 text-white rounded">
                  Edit
                </button>
                <button onClick={() => handleDeleteTask(task.id)} className="ml-2 p-1 bg-red-500 text-white rounded">
                  Delete
                </button>
              </div>
            )}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default TodoList;