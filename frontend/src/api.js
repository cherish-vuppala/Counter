const BASE = '/api/counter';

async function request(path = '', method = 'GET') {
  const res = await fetch(`${BASE}${path}`, { method });
  if (!res.ok) {
    throw new Error(`Request failed (${res.status})`);
  }
  return res.json();
}

export const getCounter = () => request();
export const increment = () => request('/increment', 'POST');
export const decrement = () => request('/decrement', 'POST');
export const reset = () => request('/reset', 'POST');
