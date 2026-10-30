import { useCounter } from './useCounter.js';

export default function App() {
  const { value, loading, error, increment, decrement, reset } = useCounter();

  return (
    <main className="card">
      <h1>Counter</h1>
      <p className="value" aria-live="polite">{value ?? '–'}</p>
      {error && <p role="alert" className="error">{error}</p>}
      <div className="actions">
        <button onClick={decrement} disabled={loading}>− Decrement</button>
        <button onClick={increment} disabled={loading}>+ Increment</button>
        <button onClick={reset} disabled={loading} className="secondary">Reset</button>
      </div>
    </main>
  );
}
