const api = {
  get: (endpoint) => fetch(endpoint, { headers: { Authorization: `Bearer ${localStorage.getItem('token')}` } }).then(res => res.json()),
  post: (endpoint, data) => fetch(endpoint, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json', Authorization: `Bearer ${localStorage.getItem('token')}` },
    body: JSON.stringify(data)
  }).then(res => res.json()),
  put: (endpoint, data) => fetch(endpoint, {
    method: 'PUT',
    headers: { 'Content-Type': 'application/json', Authorization: `Bearer ${localStorage.getItem('token')}` },
    body: JSON.stringify(data)
  }).then(res => res.json()),
  delete: (endpoint) => fetch(endpoint, {
    method: 'DELETE',
    headers: { Authorization: `Bearer ${localStorage.getItem('token')}` }
  }).then(res => res.json())
};

export default api;