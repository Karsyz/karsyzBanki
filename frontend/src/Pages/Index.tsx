import { useState, useEffect } from 'react';
import { questions } from '../data/questions';

const Index = () => {
  // const [loading, setLoading] = useState<boolean>(true);
  // const [error, setError] = useState<string | null>(null);
  const [curQ, setCurQ] = useState<number>(0);

  // Render error state

  return (
    <div className="w-full h-screen overflow-hidden flex flex-col gap-10 p-20">
      <h1 className="font-bold text-blue-500 text-5xl">Banki Practice</h1>

      <section className="flex flex-col w-fit">
        <div className="bg-green-400 rounded-md flex flex-col gap-3 p-6">
          <h2 className="font-bold  text-slate-700 text-2xl">Last Practiced</h2>
          <p className="">Keep track of your answers.</p>
        </div>
      </section>
      <section className="bg-orange-300 rounded-lg p-6">
        <div className="">
          <h3 className="font-bold text-2xl">Question</h3>
          <p className="font-semibold text-xl">{questions[curQ]?.question}</p>
        </div>
      </section>

      <section className="bg-orange-300 rounded-lg p-6">
        <div className="">
          <h3 className="font-bold text-2xl">Answer</h3>
          <p className="font-semibold text-xl">{questions[curQ]?.answer}</p>
        </div>
      </section>

      <section className="bg-blue-100 rounded-lg p-6">
        <button>Next Question</button>
        <div className="">
          <h3 className="font-bold text-2xl">Question</h3>
          <p className="font-semibold text-xl">{questions[curQ]?.question}</p>
        </div>
      </section>
    </div>
  );
};

export default Index;
