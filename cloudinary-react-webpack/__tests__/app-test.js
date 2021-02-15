import React from 'react';
import {render, screen} from '@testing-library/react'
import App from '../src/App';

describe('App', () => {
  it('Should render an AdvancedImage', () => {
    render(<App/>);
    expect(screen.getByText('img')).toBeTruthy();
  });
});