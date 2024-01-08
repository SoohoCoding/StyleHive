// NoticeList.js
import React, { useState, useEffect } from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faAngleDoubleLeft, faAngleLeft, faAngleRight, faAngleDoubleRight } from '@fortawesome/free-solid-svg-icons';
import Header from '../components/Header';
import Footer from '../components/Footer';
import Nav from './Nav';
import './NoticeList.css';
import axios from 'axios'; // axios 추가

const NoticeList = () => {
  const [notices, setNotices] = useState([]);
  const [currentPage, setCurrentPage] = useState(1);
  const [totalPages, setTotalPages] = useState(0); // 총 페이지 수 추가
  const [loading, setLoading] = useState(true); // 로딩 상태 추가

  useEffect(() => {
      const fetchNotices = async () => {
        try {
          const response = await axios.get(`http://localhost:8080/api/notices?page=${currentPage}`);
          setNotices(response.data.content);
          setTotalPages(response.data.totalPages);
        } catch (error) {
          console.error('Error fetching notices:', error);
        } finally {
               // 로딩 상태를 false로 설정
               setLoading(false);
        }
      };

    // 페이지 로딩 시에만 호출되도록 수정
      if (loading) {
        fetchNotices();
      }
  }, [currentPage, loading]);

  const handlePageChange = (newPage) => {
    if (newPage < 1) {
      setCurrentPage(1);
    } else if (newPage > totalPages) {
      setCurrentPage(totalPages);
    } else {
      setCurrentPage(newPage);
    }
  };

  const renderPageNumbers = () => {
    const pageNumbers = [];
    const maxPagesToShow = 5;
    const startPage = Math.max(1, currentPage - Math.floor(maxPagesToShow / 2));
    const endPage = Math.min(startPage + maxPagesToShow - 1, totalPages);
  
    for (let i = startPage; i <= endPage; i++) {
      pageNumbers.push(
        <span
          key={i}
          onClick={() => handlePageChange(i)}
          className={`${i === startPage ? 'first-page' : ''} ${i === currentPage ? 'active' : ''}`}
        >
          {i}
        </span>
      );
    }
  
    return pageNumbers;
  };

  return (
    <>
    <Header />
      <div className="container">
        <Nav />
      <div className="content">
        <div className="notice-header">
          <h3>공지사항</h3>
        </div>
        {loading ? (
                  <p>Loading...</p>
                ) : (
                  <>
        <ul className="notices-list">
          {notices.map((notice) => (
            <li key={notice.noticeNo}>{notice.noticeCate} {notice.noticeTitle}</li>
          ))}
        </ul>
        <div className="pagination">
          <div className='prev_btn_box'>
            <button onClick={() => handlePageChange(1)} disabled={currentPage === 1}>
              <FontAwesomeIcon icon={faAngleDoubleLeft} />
            </button>
            <button onClick={() => handlePageChange(currentPage - 1)} disabled={currentPage === 1}>
              <FontAwesomeIcon icon={faAngleLeft} />
            </button>
          </div>
          {renderPageNumbers()}
          <div className='next_btn_box'>
            <button onClick={() => handlePageChange(currentPage + 1)} disabled={currentPage === totalPages}>
              <FontAwesomeIcon icon={faAngleRight} />
            </button>
            <button onClick={() => handlePageChange(totalPages)} disabled={currentPage === totalPages}>
              <FontAwesomeIcon icon={faAngleDoubleRight} />
            </button>
          </div>
        </div>
        </>
                )}
      </div>
      </div>
      <Footer />
    </>
  );
};

export default NoticeList;
