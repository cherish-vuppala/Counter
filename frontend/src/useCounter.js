import { useCallback, useEffect, useState } from 'react';
import * as api from './api.js';

export function useCounter() {
  const [value, setValue] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  const run = useCallback(async (action) => {
    setLoading(true);
    setError(null);
    try {
      const data = await action();
      setValue(data.value);
    } catch (e) {
      setError(e.message);
    } finally {
      setLoading(false);
    }
  }, []);

  useEffect(() => {
    run(api.getCounter);
  }, [run]);

  return {
    value,
    loading,
    error,
    increment: () => run(api.increment),
    decrement: () => run(api.decrement),
    reset: () => run(api.reset),
  };
}
