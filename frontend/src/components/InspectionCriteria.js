// InspectionCriteria.js
// 검수 기준

import React, { useState, useEffect } from 'react';
import axios from 'axios';
import Header from '../components/Header';
import Footer from '../components/Footer';
import Nav from './Nav';
import './InspectionCriteria.css';

// 선택된 셀의 내용에 HTML 적용을 위한 함수
const createMarkup = (htmlContent) => {
  return { __html: htmlContent };
};

const InspectionCriteria = () => {
  // 각 칸의 내용
  const gridContents = [
    '신발',
    '아우터 · 상의 · 하의',
    '가방 · 시계 · 지갑 · 패션잡화',
    '테크',
    '뷰티 · 컬렉터블 · 캠핑 · 가구/리빙',
    '프리미엄 시계',
    '프리미엄 가방',
  ];

  // 칸을 클릭하면 보여질 내용을 관리하는 상태
  const [selectedContent, setSelectedContent] = useState(gridContents[0]);
  const [inspectionContent, setInspectionContent] = useState('');

  // 칸을 클릭했을 때 해당 내용을 설정하는 함수
  const fetchInspectionContent = async (content) => {
    try {
        const response = await axios.get(`http://localhost:8080/api/inspection/${content}`);
        setInspectionContent(response.data ? response.data.inspectionContent : '');
    } catch (error) {
        console.error('Error fetching inspection criteria:', error);
    }
  };

  useEffect(() => {
    if (selectedContent) {
      fetchInspectionContent(selectedContent);
    }
  }, [selectedContent]);

  const handleCellClick = (content) => {
    if (content) {
      setSelectedContent(content === selectedContent ? null : content);
    }
  };

  return (
    <>
    <Header />
      <div className="container">
      <Nav />
    <div className="inspection-criteria">
      <div className="inspection-criteria-header">
        <h3>검수기준</h3>
      </div>
      <table>
  <tbody>
    {[0, 1, 2].map((rowIndex) => (
      <tr key={rowIndex}>
        {[0, 1, 2].map((colIndex) => {
          const index = rowIndex * 3 + colIndex;
          const content = gridContents[index];
          const isSelectable = !!content;

          return (
            <td
              key={colIndex}
              className={`${
                content === selectedContent ? 'selected' : ''
              } ${isSelectable ? 'selectable' : ''}`}
              onClick={() => handleCellClick(content)}
            >
              <a className="cell-link">{content}</a>
            </td>
          );
        })}
      </tr>
    ))}
  </tbody>
</table>

      {/* 선택된 칸의 내용을 보여주는 부분 */}
      {selectedContent && (
        <div className="selected-content">
          <p dangerouslySetInnerHTML={createMarkup(inspectionContent)} />
        </div>
      )}
    </div>
      </div>
      <Footer />
    </>
  );
};

export default InspectionCriteria;
