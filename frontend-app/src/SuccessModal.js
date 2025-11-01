import React from "react";

const SuccessModal = ({ message, onClose }) => {
  return (
    <div className="fixed inset-0 bg-black/40 flex items-center justify-center z-50">
      <div className="bg-white rounded-2xl shadow-xl w-80 p-6 text-center animate-fadeIn">
        <h2 className="text-2xl font-semibold text-green-600 mb-3">Success 🎉</h2>
        <p className="text-gray-700 mb-6">{message}</p>
        <button
          onClick={onClose}
          className="bg-green-500 hover:bg-green-600 text-white font-medium py-2 px-6 rounded-xl transition"
        >
          Okay
        </button>
      </div>
    </div>
  );
};

export default SuccessModal;
